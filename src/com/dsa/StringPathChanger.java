package com.dsa;
import java.util.*;
import java.util.stream.Collectors;

public class StringPathChanger {
    public String changeDirectoryString(String currentDirectory, String command) throws IllegalStateException{
        String[] currentDirs =  currentDirectory.split("/");
        List<String> dirList = new ArrayList<>(Arrays.asList(currentDirs));
        if(!command.startsWith("cd")){
            throw new IllegalStateException();
        }
        
        String targetDir = command.split("\\s")[1];
        if(targetDir.equals(currentDirectory)) {
        	return currentDirectory;
        }
        if(targetDir!=null){
        	targetDir = targetDir.trim();
            if(targetDir.equals("/")){
                return "/";
            }
            if(currentDirectory.startsWith(targetDir)) {
            	return targetDir;
            }
            
            if(targetDir.startsWith(currentDirectory)) {
            	targetDir = targetDir.substring(currentDirectory.length()+1);
            }
            if(targetDir.equals("..")){
                dirList.remove(dirList.size()-1);                
            }else{
                String[] targetDirs = targetDir.split("/");
                if(targetDirs.length>0){
                    for(String dir : targetDirs){
                        if(dir.equals("..")){
                            dirList.remove(dirList.size()-1);
                        }else{
                            dirList.add(dir);
                        }
                    
                    }                    
                }
            }
            return formDirectory(dirList);
        }
        
        return null;
    }
    public String formDirectory(List<String> dirList){
        return dirList.stream().skip(1).map(s -> "/"+s).collect(Collectors.joining(""));
    }
    public static void main(String args[]) {
    	StringPathChanger stringPathChanger= new StringPathChanger();
        System.out.println(stringPathChanger.changeDirectoryString("/test/task/java", "c/"));
    }
}
