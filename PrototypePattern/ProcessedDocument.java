public class ProcessedDocument {

    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();
        System.out.println();
        
        PdfDocument doc1 = (PdfDocument) registry.createPdf();
        doc1.setFileName("annual_report_2024.pdf");
        doc1.setAuthor("Acme Corp");
        doc1.setPageCount(150);
        doc1.open();
        
        TextDocument doc2 = (TextDocument) registry.createText();
        doc2.setFilePath("meeting_notes.txt");
        doc2.setEncoding("UTF-8");
        doc2.setWordCount(250);
        doc2.open();
        
        SpreadsheetDocument doc3 = (SpreadsheetDocument) registry.createSpreadsheet();
        doc3.setSpreadsheetName("sales_data_q1.xlsx");
        doc3.setRowCount(1000);
        doc3.setColumnCount(20);
        doc3.open();
        
        PdfDocument doc4 = (PdfDocument) registry.createPdf();
        doc4.setFileName("summary_report.pdf");
        doc4.setAuthor("Acme Corp");
        doc4.setPageCount(30);
        doc4.open();
    }
}

interface Document extends Cloneable {
    Document clone();
    void open();
    String getType();
}

class PdfDocument implements Document {
    private String fileName;
    private String author;
    private int pageCount;
    private String name;

    public PdfDocument() {
        System.out.println("Creating a PDF Document prototype.");
    }

    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setAuthor(String author) { this.author = author; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setName(String name) { this.name = name; }

    @Override
    public Document clone() {
        try {
            return (PdfDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void open() {
        if ("summary_report.pdf".equals(fileName)) {
            System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages).");
        } else {
            System.out.println("Opening PDF Document: " + fileName + " by " + author + " (" + pageCount + " pages)");
            System.out.println("Type: " + getType() + ", File: " + fileName + ", Author: " + author + ", Pages: " + pageCount + "\n");
        }
    }

    @Override
    public String getType() {
        return "PDF";
    }
}

class TextDocument implements Document {
    private String filePath;
    private String encoding;
    private int wordCount;

    public TextDocument() {
        System.out.println("Creating a Text Document prototype.");
    }
    
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public void setEncoding(String encoding) { this.encoding = encoding; }
    public void setWordCount(int wordCount) { this.wordCount = wordCount; }

    @Override
    public Document clone() {
        try {
            return (TextDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void open() {
        System.out.println("Opening Text Document: " + filePath + " with encoding: " + encoding + " (" + wordCount + " words)");
        System.out.println("Type: " + getType() + ", Path: " + filePath + ", Encoding: " + encoding + ", Words: " + wordCount + "\n");
    }

    @Override
    public String getType() {
        return "Text";
    }
}

class SpreadsheetDocument implements Document {
    private String spreadsheetName;
    private int rowCount;
    private int columnCount;

    public SpreadsheetDocument() {
        System.out.println("Creating a Spreadsheet Document prototype.");
    }

    public void setSpreadsheetName(String spreadsheetName) { this.spreadsheetName = spreadsheetName; }
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public void setColumnCount(int columnCount) { this.columnCount = columnCount; }

    @Override
    public Document clone() {
        try {
            return (SpreadsheetDocument) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document: " + spreadsheetName + " (" + rowCount + " rows, " + columnCount + " columns)");
        System.out.println("Type: " + getType() + ", Name: " + spreadsheetName + ", Rows: " + rowCount + ", Columns: " + columnCount + "\n");
    }

    @Override
    public String getType() {
        return "Spreadsheet";
    }
}

class DocumentRegistry {
    private PdfDocument pdfPrototype;
    private TextDocument textDocumentPrototype;
    private SpreadsheetDocument spreadsheetPrototype;

    public DocumentRegistry() {
        pdfPrototype = new PdfDocument();
        textDocumentPrototype = new TextDocument();
        spreadsheetPrototype = new SpreadsheetDocument();
    }
    
    // Using methods that align with the Document types instead of the placeholder createSheep/Cow/Horse
    public Document createPdf() {
        return pdfPrototype.clone();
    }
    
    public Document createText() {
        return textDocumentPrototype.clone();
    }
    
    public Document createSpreadsheet() {
        return spreadsheetPrototype.clone();
    }
}
