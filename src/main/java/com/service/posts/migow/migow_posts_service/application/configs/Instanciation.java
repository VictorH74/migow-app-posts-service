package com.service.posts.migow.migow_posts_service.application.configs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.CreateManyCommentUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers.CreateManyFollowerUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreateManyPostUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments.CreateManyReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.CreateManyUserUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Follower;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;

@Configuration
public class Instanciation implements CommandLineRunner {

        @Autowired
        CreateManyUserUseCase createManyUserUseCase;
        @Autowired
        CreateManyPostUseCase createManyPostUseCase;
        @Autowired
        CreateManyCommentUseCase createManyCommentUseCase;
        @Autowired
        CreateManyReplyCommentUseCase createManyReplyCommentUseCase;
        @Autowired
        CreateManyFollowerUseCase createManyFollowerUseCase;

        @Override
        public void run(String... args) throws Exception {
                User[] users = new User[] {
                                new User(UUID.fromString("fc7dc70e-067b-414d-8a9d-35a2bb5c8736"), "vyctor7410",
                                                "Victor Almeida", "victor@gmail.com"),
                                new User(UUID.fromString("9bca54b4-6cfe-4f76-8a11-def9c829e627"), "nickT_776",
                                                "Nikolas Tesla", "nick@gmail.com"),
                                new User(UUID.fromString("90f7c337-cc45-4af6-82df-13a7c8cad090"), "mary-988",
                                                "Marina Silva", "mari@gmail.com"),
                                new User(UUID.fromString("d3ead047-ac78-4c2e-b6f4-dd3e306b58bb"), "jeorge421",
                                                "Jeorge Borges",
                                                "j.borges@gmail.com"),
                                new User(UUID.fromString("7198b869-bf2e-4f73-bb31-981961b3bd5c"), "gabby_sousa78",
                                                "Gabrielly Sousa",
                                                "gabbs@gmail.com"),
                                new User(UUID.fromString("e8ba5172-a8a6-4298-80a4-dab22029b951"), "joice_p@98",
                                                "Joice Pereira", "joy@gmail.com"),
                                new User(UUID.fromString("94191aca-bc3e-45e8-845b-e5df73957f48"), "Gvana123",
                                                "Geovana Bragas",
                                                "g-bragas@gmail.com"),
                                new User(UUID.fromString("1e0a91e8-cc47-4e3b-acb7-31b1349257a9"), "math#Silva",
                                                "Matheus Silva",
                                                "math@gmail.com"),
                                new User(UUID.fromString("b68180aa-d790-4a17-85bc-972cd2644655"), "Lidia123",
                                                "Lidia Nogueira",
                                                "lidia@gmail.com"),
                                new User(UUID.fromString("32ec771a-f70c-4b13-a231-234b32fc2fee"), "karlos7999",
                                                "Karlos Almendra",
                                                "karlos@gmail.com"),
                                new User(UUID.fromString("9dfdb019-59f1-4742-beec-cf03054178c5"), "nicolinha578",
                                                "Nicole Dias",
                                                "nic-dias@gmail.com"),
                };

                List<User> savedUsers = createManyUserUseCase.execute(List.of(users));

                int[][] usersIndexesArray = new int[][] {
                                { 0, 1 }, { 0, 2 }, { 0, 4 }, { 0, 5 }, { 0, 7 }, { 0, 9 },
                                { 1, 0 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 8 },
                                { 2, 0 }, { 2, 3 }, { 2, 4 }, { 2, 7 }, { 2, 8 }, { 2, 9 },
                                { 3, 2 }, { 3, 4 }, { 3, 5 }, { 3, 7 }, { 3, 8 },
                                { 4, 1 }, { 4, 2 }, { 4, 3 }, { 4, 6 }, { 4, 9 },
                                { 5, 1 }, { 5, 3 }, { 5, 6 }, { 5, 7 }, { 5, 8 },
                                { 6, 0 }, { 6, 1 }, { 6, 4 }, { 6, 7 }, { 6, 8 },
                                { 7, 0 }, { 7, 3 }, { 7, 6 }, { 7, 9 },
                                { 8, 0 }, { 8, 2 }, { 8, 5 }, { 8, 7 }, { 8, 9 }, { 9, 0 },
                                { 9, 1 }, { 9, 3 }, { 9, 5 }, { 9, 7 },
                };

                List<Follower> followers = new ArrayList<>();
                for (int[] usersIndexes : usersIndexesArray) {
                        FollowerPK pk = new FollowerPK();
                        pk.setFollowerUser(savedUsers.get(usersIndexes[0]));
                        pk.setFollowedUser(savedUsers.get(usersIndexes[1]));
                        Follower follower = new Follower();
                        follower.setId(pk);
                        followers.add(follower);
                }
                createManyFollowerUseCase.execute(followers);

                Post post1 = new Post();
                post1.setowner(savedUsers.get(0));
                post1.setText("✨my post to testing✨");

                Post post2 = new Post();
                post2.setowner(savedUsers.get(2));
                post2.setText("hello guysss!! 😁😁😁🚀");

                Post post3 = new Post();
                post3.setowner(savedUsers.get(5));
                post3.setText("Welcome to the django!!");

                Post post4 = new Post();
                post4.setowner(savedUsers.get(7));
                post4.setText("Ples share my post 🙏");

                List<Post> posts = new ArrayList<>();
                posts.add(post1);
                posts.add(post2);
                posts.add(post3);
                posts.add(post4);

                List<Post> savedPosts = createManyPostUseCase.execute(posts);

                Comment comment1 = new Comment();
                comment1.setOwner(savedUsers.get(1));
                comment1.setPost(savedPosts.get(0));
                comment1.setContent("Nice!");

                Comment comment2 = new Comment();
                comment2.setOwner(savedUsers.get(8));
                comment2.setPost(savedPosts.get(0));
                comment2.setContent("fantastic");

                Comment comment3 = new Comment();
                comment3.setOwner(savedUsers.get(5));
                comment3.setPost(savedPosts.get(0));
                comment3.setContent("awsome!!!");

                Comment comment4 = new Comment();
                comment4.setOwner(savedUsers.get(9));
                comment4.setPost(savedPosts.get(0));
                comment4.setContent("👏👏👏");

                List<Comment> comments = new ArrayList<>();
                comments.add(comment1);
                comments.add(comment2);
                comments.add(comment3);
                comments.add(comment4);

                List<Comment> savedComments = createManyCommentUseCase.execute(comments);

                ReplyComment rComment1 = new ReplyComment();
                rComment1.setComment(savedComments.get(0));
                rComment1.setOwner(savedUsers.get(0));
                rComment1.setContent("✨😎✨");

                ReplyComment rComment2 = new ReplyComment();
                rComment2.setComment(savedComments.get(0));
                rComment2.setOwner(savedUsers.get(1));
                rComment2.setContent("🚀🚀🚀🚀");

                List<ReplyComment> replyComments = new ArrayList<>();
                replyComments.add(rComment1);
                replyComments.add(rComment2);

                createManyReplyCommentUseCase.execute(replyComments);
        }

}
