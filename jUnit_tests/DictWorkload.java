//package voc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.python.java.data.Post;
import org.python.types.Dict;
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
        DictWorkload dictWorkload = new DictWorkload();
        List<Post> posts = dictWorkload.readPost();
        Map<org.python.Object, org.python.Object> dict_map = new HashMap<>();
        for (int i = 0; i < posts.size(); i++) {
            dict_map.put(new Str(posts.get(i).getId()), new Str(posts.get(i).getTitle()));
        }
//        System.out.println(posts.size());
        Dict dict = new Dict(dict_map);
        Dict dict1 = (Dict) dict.copy();
        System.out.println("dict" + dict.__repr__().toString());
        System.out.println("dict1 " + dict1.__repr__().toString());
        System.out.println("dict keys " + dict.keys().toString());
        System.out.println("dict items " + dict.items().toString());
        for (int i = 0; i < 500; i++) {
            dict1.popitem();
        }
        System.out.println("dict1 after poping " + dict1.__repr__().toString());
        Dict dict2 = (Dict) Dict.fromkeys(dict1, new Str("New book"));
        System.out.println("dict 2 " + dict2.__repr__().toString());
        System.out.println("dict length " + dict.__len__().toString());
    }
}
