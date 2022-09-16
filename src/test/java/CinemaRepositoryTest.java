import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CinemaRepositoryTest {

    AddItem item1 = new AddItem(1, "Shrek");
    AddItem item2 = new AddItem(2, "Shrek 2");
    AddItem item3 = new AddItem(3, "Shrek 3");

    @Test
    public void findAllTest() {
        CinemaRepository repo = new CinemaRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        AddItem[] expected = {item1, item2, item3};
        AddItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestOverMaxLimitToShow() {
        CinemaRepository repo = new CinemaRepository(1);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        AddItem[] expected = {item3};
        AddItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestUnderMaxLimitToShow() {
        CinemaRepository repo = new CinemaRepository(5);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        AddItem[] expected = {item3, item2, item1};
        AddItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTestIfArrayIsEmpty() {
        CinemaRepository repo = new CinemaRepository();

        AddItem[] expected = {};
        AddItem[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTestIfArrayIsEmpty() {
        CinemaRepository repo = new CinemaRepository();

        AddItem[] expected = {};
        AddItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
