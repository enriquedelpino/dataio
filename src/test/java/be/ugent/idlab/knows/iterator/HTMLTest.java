package be.ugent.idlab.knows.iterator;

import be.ugent.idlab.knows.TestCore;
import be.ugent.idlab.knows.iterators.HTMLSourceIterator;
import org.junit.Test;

public class HTMLTest extends TestCore {

    @Test
    public void evaluate_0000_HTML(){
        HTMLSourceIterator htmlSourceIterator = new HTMLSourceIterator();
        htmlSourceIterator.open(makeLocalAccess("/html/0000.html", "", "html", "utf-8"), "table tbody tr");

        evaluate_0000(htmlSourceIterator, false);
    }

    @Test
    public void evaluate_0001_HTML(){
        HTMLSourceIterator htmlSourceIterator = new HTMLSourceIterator();
        htmlSourceIterator.open(makeLocalAccess("/html/0001.html", "", "html", "utf-8"), "table tbody tr");

        evaluate_0001(htmlSourceIterator);
    }

    @Test
    public void evaluate_1001_header_col_missing_html(){
        HTMLSourceIterator htmlSourceIterator = new HTMLSourceIterator();
        htmlSourceIterator.open(makeLocalAccess("/html/1001_header_col_missing.html", "", "html", "utf-8"), "table tbody tr");
        //TODO should fail, check if it does
    }

    @Test
    public void evaluate_1001_header_long_html(){
        HTMLSourceIterator htmlSourceIterator = new HTMLSourceIterator();
        htmlSourceIterator.open(makeLocalAccess("/html/1001_header_long.html", "", "html", "utf-8"), "table tbody tr");
        evaluate_1001_header_long(htmlSourceIterator);
    }

    @Test
    public void evaluate_1001_header_short_html(){
        HTMLSourceIterator htmlSourceIterator = new HTMLSourceIterator();
        htmlSourceIterator.open(makeLocalAccess("/html/1001_header_short.html", "", "html", "utf-8"), "table tbody tr");
        evaluate_1001_header_short(htmlSourceIterator);
    }
}
