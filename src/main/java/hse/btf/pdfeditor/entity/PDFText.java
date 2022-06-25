package hse.btf.pdfeditor.entity;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.font.FontProvider;
import hse.btf.pdfeditor.utils.Fonts;

import java.io.IOException;

public class PDFText extends PDFItem {
    public static final String defaultText = "default text";
    public static final String defaultFont = Fonts.FREE_SANS;
    public static final Color defaultColor = ColorConstants.BLACK;

    private String text;
    private PdfFont textFont;
    private Color textColor;

    public PDFText(double x, double y, double w, double h) {
        super(x, y, w, h);
        setText(defaultText);
        setTextFont(defaultFont);
        setTextColor(defaultColor);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setTextFont(String font) {
        try {
            this.textFont = PdfFontFactory.createFont(font, PdfEncodings.IDENTITY_H);
        } catch (IOException e) {
            System.out.println("Font not found");
        }
    }

    public String getText() {
        return text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public PdfFont getTextFont() {
        return textFont;
    }
}
