package Physics;

import Basics.Time;
import Main.Main;
import Sprite.Sphere;

public class MoveEngine {

    private static boolean change = true;

    public MoveEngine(long now, Sphere xySphere, Sphere xzSphere, Sphere yzSphere){

        if (change){
            Time.curTime = System.currentTimeMillis();
            change = false;
        }

        Time.updateTime();
        buildSumm(xySphere, xzSphere, yzSphere);
        kords(xySphere, xzSphere, yzSphere);

    }

    private void buildSumm(Sphere xySphere, Sphere xzSphere, Sphere yzSphere){

        double drag = 1.0 - (Time.timeFraction * Main.DRAG);

        // X - Y
        double vx = xySphere.getVx() + (0 * Time.timeFraction);
        double vy = xySphere.getVy() + (Main.GRAVITY * Time.timeFraction);

        xySphere.updateVelocity(vx * drag, vy, 0);

        // X - Z
        double vx_2 = xzSphere.getVx() + (0 * Time.timeFraction);
        double vz_2 = xzSphere.getVz() + (0 * Time.timeFraction);

        xzSphere.updateVelocity(vx_2 * drag, 0 , vz_2 * drag);

        //Y - Z

        double vz_3 = yzSphere.getVz() + (0 * Time.timeFraction);
        double vy_3 = yzSphere.getVy() + (Main.GRAVITY * Time.timeFraction);

        yzSphere.updateVelocity(0, vy_3, vz_3 * drag);

    }

    private void kords(Sphere xySphere, Sphere xzSphere, Sphere yzSphere){

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

        //Y - Z
        double oldZ_3 = yzSphere.getZ0();
        double oldY_3 = yzSphere.getY0();

        double newZ_3 = oldZ_3 + (yzSphere.getVz() * Time.timeFraction);
        double newY_3 = oldY_3 + (yzSphere.getVy() * Time.timeFraction);

        yzSphere.updatePos(0, newY_3, newZ_3);

        checkGroundYZ(newY_3, yzSphere);
        checkWallYZ(newZ_3, yzSphere);

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

    private void checkGroundYZ(double groundY, Sphere yzSphere){
        if (groundY > 330){
            yzSphere.setY0(330);
            yzSphere.setVy(-yzSphere.getVy() * Main.BOUNCE);
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

    private void checkWallYZ(double wallZ, Sphere yzSphere) {
        if (wallZ > 380) {
            yzSphere.setZ0(380);
            yzSphere.setVz(-yzSphere.getVz() * Main.BOUNCE);

        }
        if (wallZ < 20) {
            yzSphere.setZ0(20);
            yzSphere.setVz(-yzSphere.getVz() * Main.BOUNCE);

        }
    }
}
