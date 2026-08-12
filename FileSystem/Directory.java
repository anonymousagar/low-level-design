package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    List<FileSystem> fileSystems = new ArrayList<>();
    String name;


    public Directory(String name){
        this.name =name;
    }

    public void add(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }

    public void ls(){
        System.out.println(name);
        for(FileSystem fileSystem: fileSystems){
            fileSystem.ls();
        }
    }
}
