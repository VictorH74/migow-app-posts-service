package com.service.posts.migow.migow_posts_service.infra.configs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateManyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships.CreateManyFriendshipUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreateManyPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateManyReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.CreateManyUserUseCase;

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
        CreateManyFriendshipUseCase createManyFriendshipUseCase;
        @Autowired
        CreateReactionUseCase createReactionUseCase;

        @Override
        public void run(String... args) throws Exception {
                User[] users = new User[] {
                                new User(UUID.fromString("fc7dc70e-067b-414d-8a9d-35a2bb5c8736"), "vyctor7410",
                                                "123456789", "Victor Almeida", "victor@gmail.com", null),
                                new User(UUID.fromString("9bca54b4-6cfe-4f76-8a11-def9c829e627"), "nickT_776",
                                                "123456789", "Nikolas Tesla", "nick@gmail.com", null),
                                new User(UUID.fromString("90f7c337-cc45-4af6-82df-13a7c8cad090"), "mary-988",
                                                "123456789", "Marina Silva", "mari@gmail.com",
                                                "https://th.bing.com/th/id/OIP.h04o3WE6Gle5wjqYLzhATwHaHa?pid=ImgDet&w=198&h=198&c=7"),
                                new User(UUID.fromString("d3ead047-ac78-4c2e-b6f4-dd3e306b58bb"), "jeorge421",
                                                "123456789", "Jeorge Borges",
                                                "j.borges@gmail.com",
                                                "https://th.bing.com/th/id/OIP.kLuVl7_2soHqjgecM56X2AHaLL?w=202&h=305&c=7&r=0&o=5&pid=1.7"),
                                new User(UUID.fromString("7198b869-bf2e-4f73-bb31-981961b3bd5c"), "gabby_sousa78",
                                                "123456789", "Gabrielly Sousa",
                                                "gabbs@gmail.com", null),
                                new User(UUID.fromString("e8ba5172-a8a6-4298-80a4-dab22029b951"), "joice_p@98",
                                                "123456789", "Joice Pereira", "joy@gmail.com",
                                                "https://th.bing.com/th/id/R.da2e546841da40cdcf60061743233500?rik=IeO7Sr%2fkUW54wQ&riu=http%3a%2f%2fwww.venmond.com%2fdemo%2fvendroid%2fimg%2favatar%2fbig.jpg&ehk=JihI5nQ0BOd0W%2bZVhtIWmqwac0NMyRMOV7%2bzryywg%2fg%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1"),
                                new User(UUID.fromString("94191aca-bc3e-45e8-845b-e5df73957f48"), "Gvana123",
                                                "123456789", "Geovana Bragas",
                                                "g-bragas@gmail.com", null),
                                new User(UUID.fromString("1e0a91e8-cc47-4e3b-acb7-31b1349257a9"), "math#Silva",
                                                "123456789", "Matheus Silva",
                                                "math@gmail.com", null),
                                new User(UUID.fromString("b68180aa-d790-4a17-85bc-972cd2644655"), "Lidia123",
                                                "123456789", "Lidia Nogueira",
                                                "lidia@gmail.com",
                                                "https://fastly.picsum.photos/id/454/200/200.jpg?hmac=N13wDge6Ku6Eg_LxRRsrfzC1A4ZkpCScOEp-hH-PwHg"),
                                new User(UUID.fromString("32ec771a-f70c-4b13-a231-234b32fc2fee"), "karlos7999",
                                                "123456789", "Karlos Almendra",
                                                "karlos@gmail.com", null),
                                new User(UUID.fromString("9dfdb019-59f1-4742-beec-cf03054178c5"), "nicolinha578",
                                                "123456789", "Nicole Dias",
                                                "nic-dias@gmail.com", null),
                };

                List<User> savedUsers = createManyUserUseCase.execute(List.of(users));

                // 0 >> 1 - 2 - 4 - 5 - 6 - 7 - 8 - 9
                // 1 >> 0 - 3 - 4 - 5 - 6 - 7 - 9
                // 2 >> 3 - 7 - 0 - 9 - 4 - 8
                // 3 >> 1 - 2 - 5 - 7 - 8 - 3 - 9
                // 4 >> 0 - 1 - 2 - 3 - 6 - 9
                // 5 >> 0 - 1 - 3 - 6 - 7 - 8 - 9
                // 6 >> 0 - 1 - 7 - 8 - 5 - 4
                // 7 >> 0 - 9 - 6 - 8 - 5 - 3 - 2
                // 8 >> 0 - 1 - 2 - 3 - 5 - 6 - 7 - 9
                // 9 >> 1 - 7 - 3 - 8 - 5 - 0 - 4

                int[][] usersIndexesArray = new int[][] {
                                { 0, 1 }, { 0, 2 }, { 0, 4 }, { 0, 5 },
                                { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 8 },
                                { 2, 3 }, { 2, 7 }, { 2, 8 }, { 2, 9 },
                                { 3, 5 }, { 3, 7 }, { 3, 8 },
                                { 4, 2 }, { 4, 3 }, { 4, 6 }, { 4, 9 },
                                { 5, 6 }, { 5, 7 }, { 5, 8 },
                                { 6, 0 }, { 6, 1 }, { 6, 7 }, { 6, 8 },
                                { 7, 0 }, { 7, 9 },
                                { 8, 0 }, { 8, 7 }, { 8, 9 }, { 9, 0 }, 
                                { 9, 1 }, { 9, 3 }, { 9, 5 }
                };

                List<Friendship> friendships = new ArrayList<>();
                for (int[] usersIndexes : usersIndexesArray) {
                        FriendshipPK pk = new FriendshipPK();
                        pk.setUser(savedUsers.get(usersIndexes[0]));
                        pk.setFriendUser(savedUsers.get(usersIndexes[1]));
                        Friendship follower = new Friendship();
                        follower.setId(pk);
                        friendships.add(follower);
                }
                createManyFriendshipUseCase.execute(friendships);

                Post post1 = new Post();
                post1.setOwner(savedUsers.get(0));
                post1.setText("✨my post to testing✨");

                Post post2 = new Post();
                post2.setOwner(savedUsers.get(2));
                post2.setText("hello guysss!! 😁😁😁🚀");

                Post post3 = new Post();
                post3.setOwner(savedUsers.get(5));
                post3.setText("Welcome to the django!!");

                Post post4 = new Post();
                post4.setOwner(savedUsers.get(7));
                post4.setText("Ples share my post 🙏");

                List<Post> posts = new ArrayList<>();
                posts.add(post1);
                posts.add(post2);
                posts.add(post3);
                posts.add(post4);

                List<Post> savedPosts = createManyPostUseCase.execute(posts);

                Comment comment1 = new Comment();
                comment1.setOwner(savedUsers.get(1));
                comment1.setPostId(savedPosts.get(0).getId());
                comment1.setContent("Nice!");

                Comment comment2 = new Comment();
                comment2.setOwner(savedUsers.get(8));
                comment2.setPostId(savedPosts.get(0).getId());
                comment2.setContent("fantastic");

                Comment comment3 = new Comment();
                comment3.setOwner(savedUsers.get(5));
                comment3.setPostId(savedPosts.get(0).getId());
                comment3.setContent("awsome!!!");

                Comment comment4 = new Comment();
                comment4.setOwner(savedUsers.get(9));
                comment4.setPostId(savedPosts.get(0).getId());
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

                CreateReactionDTO r1 = new CreateReactionDTO();
                r1.setOwnerId(savedUsers.get(1).getId());
                r1.setType(ReactionType.FUNNY.getCode());
                r1.setTargetId(savedPosts.get(0).getId());
                r1.setTargetClass("post_");

                CreateReactionDTO r2 = new CreateReactionDTO();
                r2.setOwnerId(savedUsers.get(2).getId());
                r2.setType(ReactionType.FUNNY.getCode());
                r2.setTargetId(savedPosts.get(0).getId());
                r2.setTargetClass("post_");

                CreateReactionDTO r3 = new CreateReactionDTO();
                r3.setOwnerId(savedUsers.get(3).getId());
                r3.setType(ReactionType.FUNNY.getCode());
                r3.setTargetId(savedPosts.get(0).getId());
                r3.setTargetClass("post_");

                CreateReactionDTO r4 = new CreateReactionDTO();
                r4.setOwnerId(savedUsers.get(4).getId());
                r4.setType(ReactionType.FUNNY.getCode());
                r4.setTargetId(savedPosts.get(1).getId());
                r4.setTargetClass("post_");

                CreateReactionDTO r5 = new CreateReactionDTO();
                r5.setOwnerId(savedUsers.get(5).getId());
                r5.setType(ReactionType.LOVE.getCode());
                r5.setTargetId(savedPosts.get(1).getId());
                r5.setTargetClass("post_");

                CreateReactionDTO r6 = new CreateReactionDTO();
                r6.setOwnerId(savedUsers.get(6).getId());
                r6.setType(ReactionType.SAD.getCode());
                r6.setTargetId(savedPosts.get(1).getId());
                r6.setTargetClass("post_");

                CreateReactionDTO r7 = new CreateReactionDTO();
                r7.setOwnerId(savedUsers.get(7).getId());
                r7.setType(ReactionType.FUNNY.getCode());
                r7.setTargetId(savedPosts.get(1).getId());
                r7.setTargetClass("post_");

                createReactionUseCase.execute(r1);
                createReactionUseCase.execute(r2);
                createReactionUseCase.execute(r3);
                createReactionUseCase.execute(r4);
                createReactionUseCase.execute(r5);
                createReactionUseCase.execute(r6);
                createReactionUseCase.execute(r7);
        }

}
