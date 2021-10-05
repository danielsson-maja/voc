//package voc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.python.Object;
import org.python.java.data.Post;
import org.python.types.Dict;
import org.python.types.Int;
import org.python.types.Str;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DictWorkload {
    private List<Post> readPost() {
        String filename = "post.txt";
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream
                .map(this::convertToPost)
                .filter(Objects::nonNull)
                .collect(toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private Post convertToPost(String string) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(string, Post.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        DictWorkload dictWorkload = new DictWorkload();
        List<Post> posts = dictWorkload.readPost();
        List<Dict> dicts = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            Dict dict = new Dict();
            for (int j = 0; j < posts.size(); j++) {
                dict.__setitem__(new Str(posts.get(j).getId()), new Str(posts.get(j).getTitle()));
            }
            dicts.add(dict);
        }

        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 1000; j++) {
                dicts.get(i).popitem();
            }
        }


        for (int i = 400; i < 800; i++) {
            dicts.get(i).update(dicts.get(i-1),dicts.get(i-2));
        }

        for (int i = 0; i < 400; i++) {
            Dict dict = new Dict();
            for (int j = 0; j < 1000; j++) {
                Object popitem = dicts.get(i + 400).popitem();
                Random random = new Random();
                int newval = random.nextInt();
                String title = popitem.__getitem__(Int.getInt(0)).toString();
                dict.__setitem__(new Str(title), new Str("" + newval));
            }
            dicts.set(i,dict);
        }

        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }
}
