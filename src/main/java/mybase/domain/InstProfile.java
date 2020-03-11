package mybase.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Log
@Data
@Entity
@Table(name = "inst_profile")
@NoArgsConstructor
//@AllArgsConstructor
public class InstProfile implements Serializable /*extends Account*/ {

    /*"biography": "500 internal server error",
  "id": "17841401343956222",
  "ig_id": 1038252798,
  "followers_count": 219,
  "follows_count": 161,
  "media_count": 435,
  "name": "Roman Moltanovski",
  "profile_picture_url": "https://scontent.xx.fbcdn.net/v/t51.2885-15/70732757_2475522886106542_5052961549807779840_n.jpg?_nc_cat=107&_nc_sid=86c713&_nc_ohc=bOoAHxscDBkAX_BQOQr&_nc_ht=scontent.xx&oh=d9ce7bc436d308d62368954f7954b1b7&oe=5E9862A6",
  "username": "romarioagrow",
  "website": "http://linkedin.com/in/romarioagrow"*/


    public InstProfile(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "main_user_id")
    private String mainUserID;

    private Integer followersAmount, followingAmount;

    private String biography, fullName, pic, picFull;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> followers;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> following;

    /*@ManyToMany
    @JoinTable(
            name = "inst_followers",
            joinColumns = @JoinColumn(name = "user_inst_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_inst_id")
    )
    private List<InstProfile> followers;*/

    /*@ManyToMany
    @JoinTable(
            name = "inst_following",
            joinColumns = @JoinColumn(name = "user_inst_id"),
            inverseJoinColumns = @JoinColumn(name = "following_inst_id")
    )
    private List<InstProfile> following;*/

    //private Object media;

    /*@ManyToMany
    @JoinTable(
            name = "inst_followers",
            joinColumns = @JoinColumn(name = "user_inst_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_inst_id")
    )
    private List<InstProfile> followers;

    @ManyToMany
    @JoinTable(
            name = "inst_following",
            joinColumns = @JoinColumn(name = "user_inst_id"),
            inverseJoinColumns = @JoinColumn(name = "following_inst_id")
    )
    private List<InstProfile> following;*/
}