import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.*;

public class Quit implements Command {
  public String name() { return "quit"; }
  public boolean run(Scanner obj) { return true ;}
}
