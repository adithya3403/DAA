// sp36 Vehicles

/*

KCR Chief Minister of Telangana Government has passed a new G.O to 
Telangana police for safety of Telangana people. In this regard, the CM announced 
new Vehicles to be released for all the stations working for this mission especially.

Here we have a 2D mesh, there are P police officers and V vehicles, with P<=V.
Each police officer and vehicle is a 2D coordinate on this mesh.
Here the government has assigned a unique vehicle to each police officer.

Now create a method which prints the minimum possible sum of distances between 
each police officer and their assigned vehicle.

Here the distance is between police officer Pi and vehicle Vi assigned to him.
And distance between Pi, Vi is calculated as follows: |Pi.x - Vi.x| + |Pi.y - Vi.y|


Input Format:
-------------
Line-1: Two integers P and V, number of police officers and vehicles.
Next P lines: Two space separated integers co-ordinates of Police officers.
Next V lines: Two space separated integers co-ordinates of Vehicles.

Output Format:
--------------
Print an integer, the minimum possible sum of distances.


Sample Input-1:
---------------
3 3
0 1		// co-ordinates of police
1 2
1 3
4 5		// co-ordinates of vehicles
2 5
3 6

Sample Output-1:
----------------
17


Sample Input-2:
---------------
2 2
0 0		// co-ordinates of police
2 1
1 2		// co-ordinates of vehicles
3 3

Sample Output-2:
----------------
6

*/

class sp36 {
    public int findDistance(int[] p, int[] v) {
        return Math.abs(p[0] - v[0]) + Math.abs(p[1] - v[1]);
    }

    public int assignVehicles(int[][] police, int[][] vehicles) {
        // Implement your logic here.
        int minSum = Integer.MAX_VALUE;
        int[] path = new int[police.length];
        for (int i = 0; i < path.length; i++)
            path[i] = -1;
        minSum = assignVehicles(police, vehicles, path, 0, minSum);
        return minSum;
    }

    int assignVehicles(int[][] police, int[][] vehicles, int[] path, int pos, int minSum) {
        if (pos == police.length) {
            int sum = 0;
            for (int i = 0; i < police.length; i++)
                sum += findDistance(police[i], vehicles[path[i]]);
            return Math.min(sum, minSum);
        }
        for (int i = 0; i < vehicles.length; i++) {
            if (isSafe(path, i)) {
                path[pos] = i;
                minSum = assignVehicles(police, vehicles, path, pos + 1, minSum);
                path[pos] = -1;
            }
        }
        return minSum;
    }

    boolean isSafe(int[] path, int i) {
        for (int j = 0; j < path.length; j++) {
            if (path[j] == i)
                return false;
        }
        return true;
    }
}