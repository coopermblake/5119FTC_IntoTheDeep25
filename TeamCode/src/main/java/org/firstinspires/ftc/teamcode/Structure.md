Important classes:
- Robot: Base class that contains robot configuration, and also links most other code.
- DriverIO: Useful code for getting input from the Driver Station and sending back telemetry.
- MecanumDrive: High-level drive class for Mecanum drive robots.
- RobotNavigation: Used to get the position of the robot on the field and request navigation to a
  location. Mostly Roadrunner code.

Note: Most of these classes (except for Robot) cannot be accessed from opmodes. This is intentional:
you should be creating an instance of Robot and using those methods through Robot instead of creating
your own instance. This allows for the Robot class to have some abstraction.