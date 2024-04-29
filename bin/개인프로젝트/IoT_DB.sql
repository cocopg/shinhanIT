drop table TimeReservation ;

-- ����� ���� ���̺� ����
CREATE TABLE Users (
    User_ID VARCHAR2(100)  PRIMARY KEY,           -- ����� ID
    Password VARCHAR2(50),                -- ��й�ȣ
    NAME VARCHAR2(100)                   -- ����� �̸�
);


-- ����̽� ���� ���̺� ����
CREATE TABLE DeviceInfo (
    Device_ID VARCHAR2(100) PRIMARY KEY,          -- ����̽� ID
    Manufacture VARCHAR2(100),            -- ����̽� ������
    D_type VARCHAR2(100),               --����
    Regist_Date DATE,                      -- ����̽� ��� �Ͻ�
    Status VARCHAR2(10),                   -- ����̽� On/Off ����
    Room_Name VARCHAR2(100),               -- ����̽��� ��ġ�� �� �̸�
    User_ID VARCHAR2(100),                        -- �ܷ� Ű: ����� ���̺��� User_ID�� ���� (����� �����)
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID) -- ����� ���� ���̺���� �ܷ� Ű ����
);

-- �ð� ���� ���̺� ����
CREATE TABLE TimeReservation (
    Reservation_ID NUMBER PRIMARY KEY,     -- ���� ID
    Device_ID VARCHAR2(100),                      -- ����̽� ID
    Start_Time TIMESTAMP,                  -- ���� �ð�
    End_Time TIMESTAMP,                    -- ���� �ð�
    FOREIGN KEY (Device_ID) REFERENCES DeviceInfo(Device_ID) -- ����̽� ���� ���̺���� �ܷ� Ű ����
);

-- Ȱ�� �α� ���̺� ����
CREATE TABLE ActivityLog (
    Log_ID NUMBER PRIMARY KEY,             -- �α� ID
    User_ID VARCHAR2(100),                        -- ����� ID
    Device_ID VARCHAR2(100),                      -- ����̽� ID
    Timestamp TIMESTAMP,                   -- �α� �ۼ� �ð�
    Status VARCHAR2(10),                   -- ���� ���� (On/Off)
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID),      
    FOREIGN KEY (Device_ID) REFERENCES DeviceInfo(Device_ID)
);

-- ����� ���� ���̺� ������ ����
INSERT INTO Users (User_ID, Password, Name) VALUES ('daddy123', '1234', '�����');
INSERT INTO Users (User_ID, Password, Name) VALUES ('momstouch', '2345', '�����');
INSERT INTO Users (User_ID, Password, Name) VALUES ('myson', '3456', '�츮��');
INSERT INTO Users (User_ID, Password, Name) VALUES ('danger', '4567', '�ݻ��');

-- ����̽� ���� ���̺� ������ ����
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('�Ž�Ƽ��', 'Samsung', 'TV', TO_DATE('2023-08-10', 'YYYY-MM-DD'), 'Off', '�Ž�', 'daddy123');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('�Žǿ�����', 'Samsung', '������', TO_DATE('2024-01-17', 'YYYY-MM-DD'), 'Off', '�Ž�', 'momstouch');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('���Ĺ��̹�', 'LG', '�����', TO_DATE('2021-05-27', 'YYYY-MM-DD'), 'On', '�ȹ�', 'myson');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('�����', '�ѻ�', '����', TO_DATE('2023-11-19', 'YYYY-MM-DD'), 'Off', '������', 'danger');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('�����濡����', 'Samsung', '������', TO_DATE('2023-07-20', 'YYYY-MM-DD'), 'Off', '������', 'danger');
INSERT INTO DeviceInfo (Device_ID, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID)
VALUES ('�ȹ�Ƽ��', 'LG', 'TV', TO_DATE('2023-06-01', 'YYYY-MM-DD'), 'Off', '�Ž�', 'momstouch');

-- �ð� ���� ���̺� ������ ����
INSERT INTO TimeReservation (Reservation_ID, Device_ID, Start_Time, End_Time)
VALUES (1, '�Žǿ�����', TO_TIMESTAMP('2024-04-11 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-11 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Ȱ�� �α� ���̺� ������ ����
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (101, 'danger', '�����', TO_TIMESTAMP('2024-04-10 08:05:50', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (102, 'daddy123', '�Ž�Ƽ��', TO_TIMESTAMP('2024-04-10 10:23:48', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (103, 'daddy123', '�Ž�Ƽ��', TO_TIMESTAMP('2024-04-10 13:32:21', 'YYYY-MM-DD HH24:MI:SS'), 'Off');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (104, 'daddy123', '�Ž�Ƽ��', TO_TIMESTAMP('2024-04-10 15:28:13', 'YYYY-MM-DD HH24:MI:SS'), 'On');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (105, 'danger', '�����', TO_TIMESTAMP('2024-04-10 16:45:17', 'YYYY-MM-DD HH24:MI:SS'), 'Off');
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (106, 'daddy123', '�Ž�Ƽ��', TO_TIMESTAMP('2024-04-10 18:01:24', 'YYYY-MM-DD HH24:MI:SS'), 'Off');

--�����ȣ �ڵ�������
CREATE SEQUENCE reservation_id_seq START WITH 1 INCREMENT BY 1;
INSERT INTO TimeReservation (Reservation_ID, Device_ID, Start_Time, End_Time)
VALUES (reservation_id_seq.NEXTVAL, '�����濡����', 
TO_TIMESTAMP('2024-04-10 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-10 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));


--�α� ��ȣ �ڵ�������
CREATE SEQUENCE log_id_seq START WITH 107 INCREMENT BY 1;
INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
VALUES (log_id_seq.NEXTVAL, 'danger', '�����', TO_TIMESTAMP('2024-04-10 08:05:50', 'YYYY-MM-DD HH24:MI:SS'), 'On');

select*from users;
select*from deviceinfo;
select*from TimeReservation order by 1;
select*from ActivityLog order by 1;

commit;

--�α���
select password
from users
where user_id=?
and password=?;

UPDATE TimeReservation
SET End_Time = TO_TIMESTAMP('2024-04-12 13:11:11', 'YYYY-MM-DD HH24:MI:SS')
WHERE Reservation_ID = 1;

update deviceInfo
set status = 'On'
where device_id = '�����濡����';

--Ÿ�ӽ����� �и��� ���� 
SELECT TO_CHAR(start_time, 'YYYY-MM-DD HH24:MI:SS'),TO_CHAR(end_time, 'YYYY-MM-DD HH24:MI:SS') AS formatted_timestamp
FROM TimeReservation;


select Device_ID as ���ID, 
Manufacture as ������, 
D_type as ����, 
Regist_Date as �����, 
Status as ����, 
Room_Name as ��ġ, 
User_ID as �����
from deviceinfo;

select device_id, Manufacture, D_type, Regist_Date, Status, Room_Name, User_ID
from deviceinfo;

update deviceinfo set status = 'On'
where device_id = '�Ž�Ƽ��';

drop trigger deviceinfo_status_change_trigger;

-- �������� �޾ƿ��� Ʈ����
CREATE OR REPLACE TRIGGER deviceinfo_status
AFTER UPDATE OF Status ON DeviceInfo
FOR EACH ROW
BEGIN
    IF :OLD.Status <> :NEW.Status THEN 
        INSERT INTO ActivityLog (Log_ID, User_ID, Device_ID, Timestamp, Status)
        VALUES (log_id_seq.NEXTVAL, :OLD.USER_ID, :OLD.Device_ID, CURRENT_TIMESTAMP, :NEW.Status);
    END IF;
END;
/











