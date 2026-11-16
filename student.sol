// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract Student {

    // Structure to store student details
    struct StudentData {
        uint id;
        string name;
        uint age;
        string course;
    }

    // Array to store multiple students
    StudentData[] public students;

    // Event for fallback function
    event FallbackCalled(address sender, uint value, bytes data);

    // Function to add student details
    function addStudent(
        uint _id,
        string memory _name,
        uint _age,
        string memory _course
    ) public {
        students.push(StudentData(_id, _name, _age, _course));
    }

    // Function to get student details
    function getStudent(uint index)
        public
        view
        returns (uint, string memory, uint, string memory)
    {
        StudentData memory s = students[index];

        return (s.id, s.name, s.age, s.course);
    }

    // Function to get total number of students
    function getStudentCount() public view returns (uint) {
        return students.length;
    }

    // Fallback function
    fallback() external payable {
        emit FallbackCalled(msg.sender, msg.value, msg.data);
    }
}
