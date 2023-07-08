package be.ugent.idlab.knows.dataio.iterator;

import be.ugent.idlab.knows.dataio.access.Access;
import be.ugent.idlab.knows.dataio.cores.TestCore;
import be.ugent.idlab.knows.dataio.exceptions.BadHeaderException;
import be.ugent.idlab.knows.dataio.iterators.ODSSourceIterator;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


public class ODSIteratorTest extends TestCore {

    @Test
    public void evaluate_0000_ods() throws XMLStreamException, SQLException, IOException {
        Access access = makeLocalAccess("/ods/0000.ods", "", "ods", "utf-8");
        try (ODSSourceIterator odsSourceIterator = new ODSSourceIterator(access)) {
            assertTrue(evaluate_0000(odsSourceIterator));
        }
    }

    @Test
    public void evaluate_0001_ods() throws XMLStreamException, SQLException, IOException {
        Access access = makeLocalAccess("/ods/0001.ods", "", "ods", "utf-8");
        try (ODSSourceIterator odsSourceIterator = new ODSSourceIterator(access)) {
            assertTrue(evaluate_0001(odsSourceIterator));
        }
    }

    @Test
    public void evaluate_1001_header_col_missing_CSV() {
        Access access = makeLocalAccess("/ods/1001_header_col_missing.ods", "", "ods", "utf-8");
        assertThrows(BadHeaderException.class, () -> {
            ODSSourceIterator iterator = new ODSSourceIterator(access);
            iterator.close();
        });
    }

    @Test
    public void evaluate_1001_header_long_CSV() throws XMLStreamException, SQLException, IOException {
        Access access = makeLocalAccess("/ods/1001_header_long.ods", "", "ods", "utf-8");
        try (ODSSourceIterator odsSourceIterator = new ODSSourceIterator(access)) {
            assertTrue(evaluate_1001_header_long(odsSourceIterator));
        }
    }

    @Test
    public void evaluate_1001_header_short_CSV() {
        Access access = makeLocalAccess("/ods/1001_header_short.ods", "", "ods", "utf-8");
        assertThrows(BadHeaderException.class, () -> {
            ODSSourceIterator odsSourceIterator = new ODSSourceIterator(access);
            odsSourceIterator.close();
        });
    }
}
