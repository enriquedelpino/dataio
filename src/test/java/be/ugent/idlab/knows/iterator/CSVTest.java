package be.ugent.idlab.knows.iterator;

import be.ugent.idlab.knows.TestCore;
import be.ugent.idlab.knows.iterators.CSVSourceIterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CSVTest extends TestCore {

    private static final Logger logger = LoggerFactory.getLogger(CSVTest.class);

    @Test
    public void evaluate_0000_CSV(){

        CSVSourceIterator csvSourceIterator = new CSVSourceIterator();
        csvSourceIterator.open(makeLocalAccess("/csv/0000.csv"));
        evaluate_0000(csvSourceIterator, false);
    }

    @Test
    public void evaluate_0001_CSV(){
        CSVSourceIterator csvSourceIterator = new CSVSourceIterator();
        csvSourceIterator.open(makeLocalAccess("/csv/0001.csv"));

        evaluate_0001(csvSourceIterator);
    }
}
