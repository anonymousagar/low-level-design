import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecoder {

    static class Point {
        int x;
        int y;
        char ch;

        Point(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }

    public static void printSecretMessage(String docUrl) {
        try {
            String html = fetchHtml(docUrl);
            List<Point> points = parseCoordinates(html);
            renderGrid(points);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fetchHtml(String docUrl) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(docUrl.trim()))
                .header("User-Agent", "Mozilla/5.0")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static List<Point> parseCoordinates(String html) {
        List<Point> points = new ArrayList<>();
        Pattern rowPattern = Pattern.compile("<tr[^>]*>(.*?)</tr>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Pattern cellPattern = Pattern.compile("<t[dh][^>]*>(.*?)</t[dh]>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

        Matcher rowMatcher = rowPattern.matcher(html);

        int xCol = 0;
        int charCol = 1;
        int yCol = 2;
        boolean headerFound = false;

        while (rowMatcher.find()) {
            List<String> cells = extractCells(cellPattern, rowMatcher.group(1));
            if (cells.size() < 3) {
                continue;
            }

            if (!headerFound) {
                for (int i = 0; i < cells.size(); i++) {
                    String col = cells.get(i).toLowerCase();
                    if (col.contains("x-coord") || col.equals("x")) {
                        xCol = i;
                    } else if (col.contains("char")) {
                        charCol = i;
                    } else if (col.contains("y-coord") || col.equals("y")) {
                        yCol = i;
                    }
                }
                headerFound = true;
                continue;
            }

            try {
                int x = Integer.parseInt(cells.get(xCol));
                int y = Integer.parseInt(cells.get(yCol));
                String val = cells.get(charCol);
                char ch = val.isEmpty() ? ' ' : val.charAt(0);

                points.add(new Point(x, y, ch));
            } catch (NumberFormatException ignored) {}
        }

        return points;
    }

    private static List<String> extractCells(Pattern cellPattern, String rowContent) {
        List<String> cells = new ArrayList<>();
        Matcher cellMatcher = cellPattern.matcher(rowContent);
        while (cellMatcher.find()) {
            String clean = cellMatcher.group(1)
                    .replaceAll("<[^>]*>", "")
                    .replace("&nbsp;", " ")
                    .trim();
            cells.add(clean);
        }
        return cells;
    }

    private static void renderGrid(List<Point> points) {
        if (points == null || points.isEmpty()) {
            return;
        }

        int maxX = 0;
        int maxY = 0;
        for (Point p : points) {
            if (p.x > maxX) maxX = p.x;
            if (p.y > maxY) maxY = p.y;
        }

        char[][] grid = new char[maxY + 1][maxX + 1];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }

        for (Point p : points) {
            grid[p.y][p.x] = p.ch;
        }

        for (int y = maxY; y >= 0; y--) {
            for (int x = 0; x <= maxX; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
        printSecretMessage(url);
    }
}