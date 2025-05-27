package org.myshop;

import pl.umcs.oop.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.util.Optional;
import java.sql.SQLException;


public record Song(String artist, String title, int duration) {
    public static class Persistence{
        public static Optional<Song> read(int index) throws  SQLException{
            String sql="SELECT * FROM song WHERE id=?;";
            PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
        }
    }
}
