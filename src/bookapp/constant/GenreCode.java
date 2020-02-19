package bookapp.constant;

public enum GenreCode {
    POEM(1, "시"), NOVEL(2, "소설"), COMIC(3, "만화");

    int value;
    String name;

    GenreCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getName(int value) {
        switch (value) {
            case 1: return POEM.name;
            case 2: return NOVEL.name;
            case 3: return COMIC.name;
            default: break;
        }
        return null;
    }
}
