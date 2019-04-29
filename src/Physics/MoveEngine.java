package Physics;

import Basics.Time;
import Main.Main;
import Sprite.Sphere;

public class MoveEngine {

    private static boolean change = true;

    public MoveEngine(long now, Sphere xySphere, Sphere xzSphere){

        if (change){
            Time.curTime = System.currentTimeMillis();
            change = false;
        }

        Time.updateTime();
        buildSumm(xySphere, xzSphere);
        kords(xySphere, xzSphere);

    }

    private void buildSumm(Sphere xySphere, Sphere xzSphere){

        double drag = 1.0 - (Time.timeFraction * Main.DRAG);

        // X - Y
        double vx = xySphere.getVx() + (0 * Time.timeFraction);
        double vy = xySphere.getVy() + (Main.GRAVITY * Time.timeFraction);

        xySphere.updateVelocity(vx * drag, vy, 0);

        // X - Z
        double vx_2 = xzSphere.getVx() + ( 0 * Time.timeFraction);
        double vz_2 = xzSphere.getVz() + (Main.GRAVITY * Time.timeFraction);

        xzSphere.updateVelocity(vx_2 * drag, 0 , vz_2);

    }

    private void kords(Sphere xySphere, Sphere xzSphere){

        // X - Y
        double oldX = xySphere.getX0();
        double oldY = xySphere.getY0();

        double newX = oldX + (xySphere.getVx() * Time.timeFraction);
        double newY = oldY + (xySphere.getVy() * Time.timeFraction);

        xySphere.updatePos(newX, newY, 0);

        checkGround(newY, xySphere);
        checkWall(newX, xySphere);

        // X - Z
        double oldX_2 = xzSphere.getX0();
        double oldZ_2 = xzSphere.getZ0();

        double newX_2 = oldX_2 + (xzSphere.getVx() * Time.timeFraction);
        double newZ_2 = oldZ_2 + (xzSphere.getVz() * Time.timeFraction);

        xzSphere.updatePos(newX_2,0, newZ_2);

        checkGroundXZ(newZ_2, xzSphere);
        checkWallXZ(newX_2, xzSphere);


    }

    private void checkGround(double groundY, Sphere xySphere){
        if (groundY > 330){
            xySphere.setY0(330);

            xySphere.setVy( -xySphere.getVy() * Main.BOUNCE);
        }
    }

    private void checkGroundXZ(double groundY, Sphere xzSphere){
        if (groundY > 330){
            xzSphere.setZ0(330);
            xzSphere.setVz(-xzSphere.getVz() * Main.BOUNCE);
        }
    }

    private void checkWall(double wallX, Sphere xySphere){
        if (wallX>380){
            xySphere.setX0(380);
            xySphere.setVx(-xySphere.getVx() * Main.BOUNCE);

        }
        if (wallX < 20){

            xySphere.setX0(20);
            xySphere.setVx(-xySphere.getVx() * Main.BOUNCE);

        }
    }

    private void checkWallXZ(double wallX, Sphere xzSphere){
        if (wallX>380){
            xzSphere.setX0(380);
            xzSphere.setVx(-xzSphere.getVx() * Main.BOUNCE);

        }
        if (wallX < 20){

            xzSphere.setX0(20);
            xzSphere.setVx(-xzSphere.getVx() * Main.BOUNCE);

        }
    }
}
