CREATE OR REPLACE TRIGGER after_employee_delete
AFTER DELETE ON employees
FOR EACH ROW
BEGIN
    -- Insert the deleted record into the backup_employees table
    INSERT INTO backup_employees (employee_id, name, position, salary, deleted_at)
    VALUES (:OLD.employee_id, :OLD.name, :OLD.position, :OLD.salary, CURRENT_TIMESTAMP);
END;
/
