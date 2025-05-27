package org.myshop;

import pl.umcs.oop.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.sql.SQLException;


public record Song(String artist, String title, int duration) {
    public static class Persistence{
        public static Optional<Song> read(int index) throws  SQLException{
            String sql="SELECT * FROM song WHERE id=?;";
            PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
            stmt.setInt(1,index);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String artist=rs.getString("artist");
                String title=rs.getString("title");
                int duration=rs.getInt("length");
                return  Optional.of(new Song(artist,title,duration));
            }else {
                return Optional.empty();
            }
        }
    }
}
