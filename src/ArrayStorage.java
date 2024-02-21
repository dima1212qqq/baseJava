import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static int add = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < add; i++) {
            storage[i] = null;
            add = 0;
        }
    }

    void save(Resume r) {
        storage[add]=r;
        add++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < add; i++) {
            if (storage[i].uuid.equals(uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < add; i++) {
            if (storage[i].uuid==uuid){
                storage[i]=null;
                for (int j = 0; j < add; j++) {
                    if (storage[j]==null){
                        storage[add]=storage[j+1];
                        storage[j+1]=storage[j];
                        storage[j]=storage[add];
                        storage[add]=null;
                    }
                }
                add--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,add);
    }

    int size() {
        return add;
    }
}
