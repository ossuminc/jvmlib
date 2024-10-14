import com.ossuminc.sbt.{Root, Module, OssumIncPlugin}
import sbt.*
import sbt.Keys.*
import sbtcrossproject.{CrossClasspathDependency, CrossProject}

Global / onChangedBuildSource := ReloadOnSourceChanges

enablePlugins(OssumIncPlugin)

lazy val riddl: Project = Root(ghRepoName = "jvmlib", orgPackage = "",
  maintainerEmail = "samuel.metcalfe@ossuminc.com", startYr = 2024)
  .configure(With.noPublishing, With.git, With.dynver, With.noMiMa, With.aliases)
  .aggregate(jvmlib)

lazy val jvmlib: Project = Module("jvmlib")
  .configure(
    With.typical,
    With.js("jvmlib", hasMain=false, forProd=true, withCommonJSModule = false)
  )
