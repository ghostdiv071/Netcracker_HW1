package entity;

public abstract class AbstractEntity {
    private int id;

    public AbstractEntity() {}

    public AbstractEntity(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Contract id \"" + id + "\" have to be larger than 0"
            );
        }
        this.id = id;
    }
}
