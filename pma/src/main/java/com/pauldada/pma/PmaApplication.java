package com.pauldada.pma;

import com.pauldada.pma.dao.ProjectRepository;
import com.pauldada.pma.dao.StudentRepository;
import com.pauldada.pma.entities.Project;
import com.pauldada.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PmaApplication {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(PmaApplication.class, args);
	}




	@Bean
	CommandLineRunner runner() {

		return args -> {

			Student student1 = new Student("赖波弛", "warton", "warton@gmail.com");
			Student student2 = new Student("毕咏湛", "lanister", "lanister@gmail.com");
			Student student3 = new Student("孙斐恋", "Reeves", "Reeves@gmail.com");

			Student student4 = new Student("成骥坤", "connor", "connor@gmail.com");
			Student student5 = new Student("单琦习", "Jim", "Sal@gmail.com");
			Student student6 = new Student("单仪柳", "Peter", "henley@gmail.com");

			Student student7 = new Student("翁列标", "Richard", "carson@gmail.com");
			Student student8 = new Student("支奕辰", "Honor", "miles@gmail.com");
			Student student9 = new Student("伍柳妍", "Roggers", "roggers@gmail.com");

			Project pro1 = new Project("大规模生产部署", "未开始", "这需要所有的人都参与到软件的最终部署生产中来。");
			Project pro2 = new Project("学习微服务架构",  "已完成", "通过微服务，可将大型应用分解成多个独立的组件，其中每个组件都有各自的责任领域。");
			Project pro3 = new Project("软件测试", "进行中", "在规定的条件下对程序进行操作，以发现程序错误，衡量软件质量。");
			Project pro4 = new Project("毕业设计规划", "进行中", "独立完成一个应用软件或较大软件中的一个或数个模块设计、调试");



			// 需要手动设定双方的关系

			pro1.addStudent(student1);
			pro1.addStudent(student2);
			pro2.addStudent(student3);
			pro3.addStudent(student1);
			pro4.addStudent(student1);
			pro4.addStudent(student3);


			// 需要手动设定双方的关系
			student1.setProjects(Arrays.asList(pro1, pro3, pro4));
			student2.setProjects(Arrays.asList(pro1));
			student3.setProjects(Arrays.asList(pro2, pro4));

			// 保存学生到数据库中

			studentRepository.save(student1);
			studentRepository.save(student2);
			studentRepository.save(student3);
			studentRepository.save(student4);
			studentRepository.save(student5);
			studentRepository.save(student6);
			studentRepository.save(student7);
			studentRepository.save(student8);
			studentRepository.save(student9);


			// 保存项目到数据库中

			projectRepository.save(pro1);
			projectRepository.save(pro2);
			projectRepository.save(pro3);
			projectRepository.save(pro4);


		};

	}

}