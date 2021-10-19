package junit.example;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface DataService {
  void saveData(@NotNull List<String> dataToSave);

  @NotNull String getDataById(@NotNull Integer id);

  @NotNull String getDataByName(@NotNull String name);

  @NotNull List<String> getData();

  final class Dummy implements DataService {
    public static final @NotNull DataService instance = new Dummy();

    @Override
    public void saveData(@NotNull List<String> dataToSave) {
    }

    @Override
    public @NotNull String getDataById(@NotNull Integer id) {
      return "";
    }

    @Override
    public @NotNull String getDataByName(@NotNull String name) {
      return "";
    }

    @Override
    public @NotNull List<String> getData() {
      return Collections.emptyList();
    }
  }

}
