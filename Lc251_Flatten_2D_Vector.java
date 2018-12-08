// time: O(n)
// space: O(1)
// 二维矩阵，只需要xy两个变量就可以


public class Vector2D implements Iterator<Integer> {
    // 需要三个变量， 一个是list，两个是index
    int x, y;
    List<List<Integer>> list = new ArrayList<>();
    
    // 初始化这个vector
    public Vector2D(List<List<Integer>> vec2d) {
        x = 0;
        y = 0;
        list = vec2d;
    }
    
    // getNext 返回下一个存在的数字
    @Override
    public Integer next() {
        return list.get(x).get(y++);
    }
    
    // 查看下一个还存不存在
    @Override
    public boolean hasNext() {
        while (x < list.size()) {
            if (y < list.get(x).size()) {
                return true;
            } else { // 转到下一个嵌套的list
                x++;
                y = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */