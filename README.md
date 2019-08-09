# spring_cloud
在pom文件中我们写了这样一个plugin：
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <configuration>
        <artifactSet>
          <excludes>
            <exclude>org.projectlombok:lombok</exclude>
          </excludes>
        </artifactSet>
          <createDependencyReducedPom>false</createDependencyReducedPom>
          <shadedArtifactAttached>true</shadedArtifactAttached>
          <shadedClassifierName>aws</shadedClassifierName>
      </configuration>
  </plugin>
  
  此代码表明当我们打包发布到aws上面时，根本不需要lombok.jar，但是在pom文件中我们又引入了此jar（在项目中编写时需要），所以需要排除掉lombok的jar包
  
  发布到aws上面，我们需要创建一个层来排除不引用的jar，我们需要创建一个文件夹，格式必须是layer\java\lib\**.jar，然后压缩即可。
  
  在发布时我们添加刚刚创建的层即可
