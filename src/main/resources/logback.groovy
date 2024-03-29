import ch.qos.logback.classic.Level
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.util.FileSize

appender("Console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

appender("R", RollingFileAppender) {
    file = "/data/logs/warPackage/info.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
    rollingPolicy(SizeAndTimeBasedRollingPolicy) {
        fileNamePattern = "logs/wztest_%d{yyyy-MM-dd}.%i.log"
        maxFileSize = "10MB"
        maxHistory = 7
        totalSizeCap = FileSize.valueOf("500MB")
    }
}

logger("io.netty", Level.WARN)
logger("ch.qos.logback", Level.WARN)
logger("org.quartz", Level.ERROR)
logger("org.apache.ibatis", Level.ERROR)
logger("org.apache.ignite", Level.ERROR)
logger("com.cloudwise", Level.INFO)

root(Level.valueOf("INFO"), ["Console", "R"])