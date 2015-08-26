package si.opeyemisonu;

import spark.Spark;

public class Hello2 {
    public static void main(String[] args) {
        Spark.get("/hello2", (req, res) -> "Hello World");
    }
}
