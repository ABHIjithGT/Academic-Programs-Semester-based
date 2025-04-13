SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE calculate_total_marks (
    p_student_id IN NUMBER,
    p_subject1_marks IN NUMBER,
    p_subject2_marks IN NUMBER,
    p_subject3_marks IN NUMBER
)
IS
    v_total_marks NUMBER;
BEGIN

    INSERT INTO sessional_exam (student_id, subject1_marks, subject2_marks, subject3_marks)
    VALUES (p_student_id, p_subject1_marks, p_subject2_marks, p_subject3_marks);

    v_total_marks := p_subject1_marks + p_subject2_marks + p_subject3_marks;

    UPDATE sessional_exam
    SET total_marks = v_total_marks
    WHERE student_id = p_student_id;

    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Total marks for Student ID ' || p_student_id || ': ' || v_total_marks);
END;
/
DECLARE
    id NUMBER;
    m1 NUMBER;
    m2 NUMBER;
    m3 NUMBER;
BEGIN
    id := &id; 
    m1 := &mark1;
    m2 := &mark2;
    m3 := &mark3;
    calculate_total_marks(id,m1,m2,m3);
    
    COMMIT;
END;
/

