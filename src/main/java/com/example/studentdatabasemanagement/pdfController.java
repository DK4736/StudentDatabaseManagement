//package com.example.studentdatabasemanagement;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.text.Text;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//public class pdfController {
//
//
//
//
//    private static String major = "sot";
//    private static String name = "akal";
//    public TextArea str;
//    private String passport = "ifdwi3";
//
//    @FXML
//    private TextField nameField;
//    @FXML
//    private TextField surnameField;
//    @FXML
//    private TextField courseField;
//    @FXML
//    private static TextField passportField;
//    @FXML
//    private Button generateButton;
//    @FXML
//    private Button browseButton;
//    private static File pdfFile;
//
////    public void initialize() {
////        browseButton.setOnAction(event -> chooseFile());
////        generateButton.setOnAction(event -> generatePdf());
////        generateButton.setDisable(true);
////    }
//
////    private void chooseFile() {
////        FileChooser fileChooser = new FileChooser();
////        fileChooser.setTitle("Save PDF");
////        fileChooser.getExtensionFilters().addAll(
////                new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
////        );
////        pdfFile = fileChooser.showSaveDialog(browseButton.getScene().getWindow());
////        if (pdfFile != null) {
////            generateButton.setDisable(false);
////        }
////    }
//
////    private void generatePdf() {{
//public void generate(ActionEvent actionEvent) {
//    Document document = new Document();
////        String text="PREZIDENT TA'LIM                                                    &#10;MUASSASALARI AGENTLIGI                                                    &#10;YANGI O'ZBEKISTON&#10;UNIVERSITETI                                                                              N. 3/7-597 2022 year&#10;&#10;&#10;&#10;&#10;                                               CERTIFICATE OF ENROLLMENT&#10;&#10;Student's full name:   &#10;Passport number:     &#10;Major:                        &#10;&#10;This Certificate of Enrollment is issued to confirm the admission of the above student to 2022/2023 academic year at New Uzbekistan University in Tashkent, Uzbekistan.&#10;The period of study in the undergraduate program at the University is from&#10;October, 2022 to June 2025.&#10;&#10;For any further information regarding the student listed above, please contact the &#10;&#10;Leading Specialist of Admission Division, K. Yusufjonov, at:&#10;e.kilichova@newuzbekistanuniversity.uz&#10;&#10;Islam ElHadary&#10;&#10;&#10;&#10;&#10;&#10;Head of Education and Methodology Department&#10;&#10;This document does not imply any financial or other obligations&#10;54, Mustagillik avenue, Tashkent, Uzbekistan, 100007";
//    String text = str.getText();
//    try {
//        PdfWriter.getInstance(document, new FileOutputStream("proveletter.pdf"));
//        document.open();
//        document.add(new Paragraph(text));
////            document.add(new Paragraph("\n"));
////            document.add(new Paragraph("Name: " + name));
//////            document.add(new Paragraph("Surname: "));// + surnameField.getText()));
////            document.add(new Paragraph("Course: " + major));
////            document.add(new Paragraph("Passport Number: " + passport));
//        document.close();
//    } catch (DocumentException | FileNotFoundException e) {
//        e.printStackTrace();
//    }
//}
//}
//}
