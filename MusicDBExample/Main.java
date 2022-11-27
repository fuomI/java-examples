package org.example;

import org.example.model.Artist;
import org.example.model.Datasource;
import org.example.model.SongArtist;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

//        List<Artist> artists = datasource.queryArtists(5);
//        if(artists == null) {
//            System.out.println("No artists!");
//            return;
//        }
//
//        for(Artist artist : artists) {
//            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
//        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Carole King", datasource.ORDER_BY_DESC);
        if(albumsForArtist == null) {
            System.out.println("Couldn't find albums for the artist");
            return;
        }


        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", datasource.ORDER_BY_DESC);
        if(songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist songArtist : songArtists) {
            System.out.println("Artist: " + songArtist.getArtistName() + " Album: " +
                    songArtist.getAlbumName() + " Track: " + songArtist.getTrack());
        }

        datasource.querySongsMetadata();

        datasource.close();
    }
}