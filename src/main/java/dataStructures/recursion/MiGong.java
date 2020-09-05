package dataStructures.recursion;

/**
 * 迷宫问题：递归回溯
 * 二维数组
 * 0：未走过； 1：墙； 2：走过，通 3：走过，不通
 * 行走策略：下->右->上->左
 * 扩展：如何求得最短路径
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组，模拟迷宫
        int map[][] = new int[8][7];
        //1 表示墙
        for (int i=0; i<7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j =0; j<8; j++)
        {
            map[j][0] =1;
            map[j][6] =1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //另外两块挡板
//        map[1][3]=1;
//        map[2][3]=1;
        //输出地图
        printMap(map);

        findWay(map,1,1);
        System.out.println("--------------");
        printMap(map);

    }

    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    public static boolean findWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }
        //(i,j)未走过时，才可以继续
        if (map[i][j] ==0)
        {
            //假定可以走
            map[i][j] = 2;
            //下->右->上->左
            if (findWay(map,i+1,j)) {
                return true;
            } else if (findWay(map,i,j+1))
            {
                return true;
            }else if (findWay(map,i-1,j))
            {
                return true;
            }else if (findWay(map,i,j-1))
            {
                return true;
            }else {
                //实际上走不通
                map[i][j]=3;
                return false;
            }
        }else {
            return false;
        }
    }

    public static void printMap(int map[][]){
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<7;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
