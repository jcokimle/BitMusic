package bitmusic.music.data;

import java.util.Date;
import java.util.HashMap;
import java.util.*;

/**
 * Class which allows to manage a song.
 * @author Elthum
 */
public class Song {
    
    //################################################################//
    //########################## ATTRIBUTES ##########################//
    //################################################################//
    
    /**
     * References the sond id.
     */
    private String songId;
    
    /**
     * References the title of the song.
     */
    private String title;
    
    /**
     * References the artist of the song.
     */
    private String artist;
    
    /**
     * References the album og the song.
     */
    private String album;
    
    /**
     * References the list of tags.
     */
    private LinkedList<String> tags;
    
    /**
     * References the song comments.
     */
    private LinkedList<Comment> comments;
    
    /**
     * References the song grades.
     */
    private HashMap<String,Grade> grades;
    
    /**
     * References the owner id.
     */
    private String ownerId;
    
    /**
     * References the rights by category.
     */
    private HashMap<String,Rights> rightsByCategory;
    
    /**
     * References the local rights
     */
    private Rights localRights;
    
    //##################################################################//
    //######################### CONSTRUCTORS ###########################//
    //##################################################################//
        
    /**
     * Basic constructor of a Song.
     * @param songId References the songId.
     * @param title References the title.
     * @param artist References the artist.
     * @param album References the album.
     * @param tags References the list of tag.
     * @param rightsByCategory References a map of rightsByCategory.
     */
    public Song(String songId, String title, String artist, String album, LinkedList<String> tags, HashMap<String,Rights> rightsByCategory) {
        this.songId = songId;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.tags = tags;
        this.rightsByCategory = rightsByCategory;
        this.localRights = new Rights(true, true, true, true);
    }
    
    //##################################################################//
    //########################### METHODS ##############################//
    //##################################################################//
    
    /**
     * Get a lightSong with the localSong attribute for the user with userId
     * @param authorId The authorId
     * @return A light song with attribute modified for the autorId.
     */
    public Song getLightSong(String userId) {
        Song lightSong = new Song( songId, title, artist, album, tags, rightsByCategory);
        lightSong.rightsByCategory = null;
        
        
        return lightSong;
    }
    
    /**
     * Add or replace a comment on a song.
     * @param comment The comment to add.
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    
    /**
     * Delete a comment from a song.
     * @param authorId The author of the song.
     */
    public void deleteComment(String authorId, Date date) {
        for (Comment comment : comments) {
            
        }
    }
    
    /**
     * Add or replace a grade to the song.
     * @param grade The grade to add or replace.
     */
    public void addGrade(Grade grade) {
        grades.put(grade.getAuthorId(), grade);
    }
    
    /**
     * Delete a grade from a song.
     * @param authorId The author of the grade.
     */
    public void deleteGrade(String authorId) {
        grades.remove(authorId);
    }
    
    /**
     * Add or update the right of a category
     * @param categoryName The category's name to update or add.
     * @param rights The rights to associate to the category.
     */
    public void updateCategory(String categoryName, Rights rights) { 
        this.rightsByCategory.put(categoryName, rights);
    }
    
    /**
     * Delete a category with its rights in a song?
     * @param categoryName The category to delete.
     */
    public void deleteCategory(String categoryName) {
        this.rightsByCategory.remove(categoryName);
    }
    
    //##################################################################//
    //####################### GETTER & SETTER ##########################//
    //##################################################################//
   
    /**
     * Getter of the attribute songId.
     * @return The song id.
     */
    public String getSongId() {
        return songId;
    }

    /**
     * Getter of the attribute title.
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of the attribute title.
     * @param title The new title of the song.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of the attribute artist.
     * @return the artist of the song.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter of the attribute album.
     * @return The album of the song.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Getter of the attribute tags.
     * @return The list of tags.
     */
    public LinkedList<String> getTags() {
        return tags;
    }


    /**
     * Getter of the attribute comments.
     * @return The list of comments.
     */
    public LinkedList<Comment> getComments() {
        return comments;
    }

    /**
     * Getter of the attribute grades.
     * @return The list of grades.
     */
    public HashMap<String,Grade> getGrades() {
        return grades;
    }

    /**
     * Getter of the attribute ownerId.
     * @return The owner id of the song.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Getter of the attribute localRight
     * @return The rights of the local user.
     */
    public Rights getLocalRights() {
        return localRights;
    }
    
    public boolean hasTag(List<String> tagList){
        
        Iterator<String> it = tagList.iterator();
        while(it.hasNext()){
            String currentTag = it.next();
            if(this.tags.contains((currentTag))){
                return true;
            }
        }
        return false;
    }
}
