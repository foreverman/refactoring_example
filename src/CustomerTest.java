import junit.framework.TestCase;

/**
 * Created by foreverman on 2017/3/31.
 */
public class CustomerTest extends TestCase
{
    public CustomerTest(String name) {
        super(name);
    }
    public void testStatement1() {
        Customer customer = new Customer("Sean");
        Movie movie1 = new Movie("Star War", Movie.REGULAR);
        Movie movie2 = new Movie("Matrix", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("Banboo", Movie.CHILDRENS);

        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 3);
        Rental rental3 = new Rental(movie3, 4);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String statement = customer.statement();
        String expectedStatement = "Rental Record for Sean\n";
        expectedStatement += "\tStar War\t2.0\n";
        expectedStatement += "\tMatrix\t9.0\n";
        expectedStatement += "\tBanboo\t3.0\n";
        expectedStatement += "Amount owed is 14.0\n";
        expectedStatement += "You earned 4 frequent renter points";
        assertEquals(expectedStatement, statement);

    }

    public void testStatement2() {
        Customer customer = new Customer("Sean");
        Movie movie1 = new Movie("Star War", Movie.REGULAR);
        Movie movie2 = new Movie("Matrix", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("Banboo", Movie.CHILDRENS);

        Rental rental1 = new Rental(movie1, 3);
        Rental rental2 = new Rental(movie2, 1);
        Rental rental3 = new Rental(movie3, 3);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String statement = customer.statement();
        String expectedStatement = "Rental Record for Sean\n";
        expectedStatement += "\tStar War\t3.5\n";
        expectedStatement += "\tMatrix\t3.0\n";
        expectedStatement += "\tBanboo\t1.5\n";
        expectedStatement += "Amount owed is 8.0\n";
        expectedStatement += "You earned 3 frequent renter points";
        assertEquals(expectedStatement, statement);

    }
}