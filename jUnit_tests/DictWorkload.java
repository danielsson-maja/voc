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
        long startTime = System.nanoTime();
        DictWorkload dictWorkload = new DictWorkload();
        List<Post> posts = dictWorkload.readPost();
        Dict dict = new Dict();
        for (int i = 0; i < posts.size(); i++) {
            dict.__setitem__(new Str(posts.get(i).getId()), new Str(posts.get(i).getTitle()));
        }
        Dict dict1 = (Dict) dict.copy();
        for (int i = 0; i < 1500; i++) {
            dict1.popitem();
        }

        //Create List of Dict
        List<Map<org.python.Object, org.python.Object>> dicts = new ArrayList<>();
        List<Object> objectList = posts.stream()
            .map(post -> dicts.stream()
                .map(dict2 -> dict2.put(new Str(post.getId()), new Str(post.getTitle())))
                .collect(toList()))
            .flatMap(Collection::stream)
            .collect(toList());
        List<Dict> dictList = objectList.stream()
            .map(object -> {
                Dict dict2 = new Dict();
                dict2.__setitem__(object.__getitem__(Int.getInt(0)), new Str(""));
                return dict2;
            })
            .collect(toList());

        Dict dict2 = (Dict) Dict.fromkeys(dict1, new Str("New book"));
        dict2.update(dict, dict1);
        for (int i = 0; i < 1000; i++) {
            Object popitem = dict2.popitem();
            Random random = new Random();
            int newval = random.nextInt();
            dict1.__setitem__(popitem.__getitem__(Int.getInt(0)), new Str("" + newval));
        }
        for (int i = 0; i < posts.size(); i++) {
            dict2.__setitem__(new Str(posts.get(i).getId()), new Str("old book"));
        }
        System.out.println("dict length " + dict.__len__().toString());
        long endTime = System.nanoTime() - startTime;
        System.out.println("Runtime: " + endTime);
    }
}
