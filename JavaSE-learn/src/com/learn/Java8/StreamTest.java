package com.learn.Java8;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        Stream.iterate(1, i -> i + 1).limit(10000).reduce(0, Integer::sum);
        IntStream.empty().filter(null).map(null).spliterator();

    }
}
