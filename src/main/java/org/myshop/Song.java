package org.myshop;

import java.sql.PreparedStatement;
import java.util.Optional;
import java.sql.SQLException;
import org.exapmle.database.DatabaseConnection;

public record Song(String artist, String title, int duration) {
    public static class Persistence{
        public static Optional<Song> read(int index){
            String sql="SELECT * FROM song WHERE id=?;";
            PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
        }
    }
}
