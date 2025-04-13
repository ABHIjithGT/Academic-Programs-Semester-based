SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE update_salary1 (
    p_emp_id IN NUMBER,
    p_percentage IN NUMBER,
    p_result OUT VARCHAR2
) 
IS
    v_current_salary employees.salary%TYPE;  
    v_new_salary employees.salary%TYPE;      
BEGIN

    SELECT emp_salary 
    INTO v_current_salary
    FROM employee
    WHERE emp_id = p_emp_id;

    v_new_salary := v_current_salary * (1 + p_percentage / 100);

    UPDATE employee
    SET emp_salary = v_new_salary
    WHERE emp_id = p_emp_id;

    COMMIT;

    p_result := 'Salary updated successfully to ' || v_new_salary;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_result := 'Employee not found.';
    WHEN OTHERS THEN
        p_result := 'Error occurred: ' || SQLERRM;
END update_salary1;
/

