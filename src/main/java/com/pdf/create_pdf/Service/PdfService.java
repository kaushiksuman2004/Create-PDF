package com.pdf.create_pdf.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    public ByteArrayInputStream createPdf() {
        logger.info("Create pdf started !!");

        String title = "God is great";
        String content = "God is great is a phrase that resonates deeply across various cultures and religions, encapsulating the profound sense of reverence, awe, and gratitude that believers feel towards a higher power. This declaration acknowledges the omnipotence, omniscience, and omnipresence of God, reflecting the belief that God’s greatness is beyond human comprehension. It serves as a reminder of the divine's role in the creation and sustenance of the universe, inspiring faith, humility, and trust in the face of life's challenges. For many, this simple yet powerful affirmation offers comfort, guidance, and a sense of connection to something far greater than themselves.";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, out);


        // set footer 
        HeaderFooter footer = new HeaderFooter(true, new Phrase(" --KS--"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);


        document.open();

        // for title
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
        Paragraph titlePara = new Paragraph(title, titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        // for content
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 15);
        Paragraph contentPara = new Paragraph(content, contentFont);
        contentPara.setAlignment(Element.ALIGN_CENTER);
        contentPara.add(new Chunk("Wow, this text is added after creating paragraph !!"));
        document.add(contentPara);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());

    }
}
