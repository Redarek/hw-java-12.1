public class CinemaRepository {
    private AddItem[] items = new AddItem[0];
    public int maxLimitToShow;

    public CinemaRepository(int maxLimitToShow) {
        this.maxLimitToShow = maxLimitToShow;
    }

    public CinemaRepository() {
        this.maxLimitToShow = 10;
    }

    public void save(AddItem item) {
        AddItem[] tmp = new AddItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public AddItem[] findAll() {
        return items;
    }

    public AddItem[] findLast() {
        int resultLength;
        AddItem[] all = this.findAll();

        if (this.findAll().length < maxLimitToShow) {
            resultLength = this.findAll().length;
        } else {
            resultLength = maxLimitToShow;
        }
        AddItem[] result = new AddItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.findAll()[this.findAll().length - 1 - i];
        }
        return result;
    }
}
