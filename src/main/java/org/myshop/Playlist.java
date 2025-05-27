package org.myshop;

import java.util.ArrayList;
public class PlayList extends ArrayList<Song> {


    public Song atsecond(int seconds)
    {
        if(seconds<0) throw new IndexOutOfBoundsException("Czas nie moze byc ujemny "+seconds);
        int timeLeft=seconds;
        for(Song s:this)
        {
            if(s.duration()>timeLeft)
            {
                return s;
            }
            else timeLeft-=s.duration();
        }
        throw new IndexOutOfBoundsException("playlista jest krotsza niz 100");
    }

}