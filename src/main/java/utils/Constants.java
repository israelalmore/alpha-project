/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Estudio-Trabajo
 */
public class Constants {
    
    //Data Storage Options
    
    public static final String STORAGE_ARRAYLIST = "ArrayList";
    public static final String STORAGE_HASHMAP = "HashMap";
    public static final String STORAGE_FILE = "File" ;
    public static final String STORAGE_FILE_SERIALIZATION = "File(serialization)";
    public static final String STORAGE_SQL_DATABASE = "SQL - Database";
    public static final String STORAGE_JPA_DATABASE = "JPA - Database" ;    
    
    private Constants(){
        throw new AssertionError("Cannot instantiate Constants class");
    }
}
