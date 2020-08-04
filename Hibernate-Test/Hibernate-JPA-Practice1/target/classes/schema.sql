--
--DROP all the existing tables.
--

DROP TABLE IF EXISTS `tbl_rms_chklist_instance_rci`;
DROP TABLE IF EXISTS `tbl_rms_rvw_chklist_rrc`;
DROP TABLE IF EXISTS `tbl_rms_resulttypes_rrt`;
DROP TABLE IF EXISTS `tbl_rms_rvw_type_rrv`;
DROP TABLE IF EXISTS `tbl_rms_project_details_rpr`;
DROP TABLE IF EXISTS `tbl_prj_project_prj`;
DROP TABLE IF EXISTS `tbl_fou_employee_emp`; 

--
-- Table -> tbl_fou_employee_emp
--
CREATE TABLE `tbl_fou_employee_emp`(
  `EMP_User_id` int(8) NOT NULL,
  `EMP_User_name` varchar(50),
   PRIMARY KEY (EMP_User_id)
);

--
--Table -> tbl_prj_project_prj
--

CREATE TABLE `tbl_prj_project_prj`(
  `PRJ_Project_id` int(8) NOT NULL,
  `PRJ_Project_name` varchar(100),
   PRIMARY KEY (PRJ_Project_id)
);

--
--Table -> tbl_rms_project_details_rpr
--

CREATE TABLE `tbl_rms_project_details_rpr` (
  `RPR_ProjectId` int(8) NOT NULL,
  `RPR_ProjectName` varchar(250) NOT NULL,
  `RPR_ProjMgrId` int(8) DEFAULT NULL,
  `RPR_ProjStatus` enum('active','inactive') DEFAULT 'active',
  `RPR_UpdatedBy` int(8) DEFAULT NULL,
  `RPR_UpdatedOn` date DEFAULT NULL,
  PRIMARY KEY (`RPR_ProjectId`),
  FOREIGN KEY (`RPR_ProjectId`) REFERENCES `tbl_prj_project_prj` (`PRJ_Project_id`),
  FOREIGN KEY (`RPR_UpdatedBy`) REFERENCES `tbl_fou_employee_emp` (`EMP_User_id`),
  FOREIGN KEY (`RPR_ProjMgrId`) REFERENCES `tbl_fou_employee_emp` (`EMP_User_id`)
);

--
--Table -> tbl_rms_rvw_type_rrv
--

CREATE TABLE `tbl_rms_rvw_type_rrv` (
  `RRV_RvwTypeId` int(8) NOT NULL AUTO_INCREMENT,
  `RRV_ProjectId` int(8) NOT NULL,
  `RRV_RvwTypeName` varchar(300) NOT NULL,
  `RRV_UpdatedBy` int(8) DEFAULT NULL,
  `RRV_UpdatedOn` date DEFAULT NULL,
  PRIMARY KEY (`RRV_RvwTypeId`),
  FOREIGN KEY (`RRV_UpdatedBy`) REFERENCES `tbl_fou_employee_emp` (`EMP_User_id`),
  FOREIGN KEY (`RRV_ProjectId`) REFERENCES `tbl_rms_project_details_rpr` (`RPR_ProjectId`)
);

--
--Table --> tbl_rms_resulttypes_rrt
--

CREATE TABLE `tbl_rms_resulttypes_rrt` (
  `RRT_ResultId` int(8) NOT NULL AUTO_INCREMENT,
  `RRT_ResultOptions` varchar(100) NOT NULL,
  `RRT_ResultDefault` int(4) NOT NULL DEFAULT '0',
  `RRT_ResultPass` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`RRT_ResultId`)
);

--
-- Table -> tbl_rms_rvw_chklist_rrc
--

CREATE TABLE `tbl_rms_rvw_chklist_rrc` (
  `RRC_ChkListId` int(8) NOT NULL AUTO_INCREMENT,
  `RRC_RvwTypeId` int(11) NOT NULL,
  `RRC_Category` enum('main','pdi') NOT NULL DEFAULT 'main',
  `RRC_ChkListType` enum('hdr','det') NOT NULL,
  `RRC_Reference` varchar(50) NOT NULL DEFAULT 'n/a',
  `RRC_Description` varchar(2000) NOT NULL DEFAULT '',
  `RRC_Tip` varchar(1000) DEFAULT NULL,
  `RRC_ChkListPos` int(4) NOT NULL,
  `RRC_ResultTypeId` int(4) DEFAULT NULL,
  `RRC_UpdatedBy` int(8) DEFAULT NULL,
  `RRC_UpdatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`RRC_ChkListId`),
  FOREIGN KEY (`RRC_RvwTypeId`) REFERENCES `tbl_rms_rvw_type_rrv` (`RRV_RvwTypeId`),
  FOREIGN KEY (`RRC_ResultTypeId`) REFERENCES `tbl_rms_resulttypes_rrt` (`RRT_ResultId`),
  FOREIGN KEY (`RRC_UpdatedBy`) REFERENCES `tbl_fou_employee_emp` (`EMP_User_id`)
);

--
-- Table -> tbl_rms_chklist_instance_rci
--

CREATE TABLE `tbl_rms_chklist_instance_rci` (
  `RCI_ChklistId` int(10) NOT NULL,
  `RCI_RvwHdrInstanceId` int(10) NOT NULL,
  `RCI_RvwIterationId` int(4) NOT NULL,
  `RCI_RvwHdrInstanceAutoId` int(10) NOT NULL,
  `RCI_ChklistAutoId` int(10) NOT NULL AUTO_INCREMENT,
  `RCI_RvwResult` enum('Pass','Fail','N/A') DEFAULT NULL,
  `RCI_UpdatedBy` int(8) DEFAULT NULL,
  `RCI_UpdatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`RCI_ChklistId`,`RCI_RvwHdrInstanceId`,`RCI_RvwIterationId`),
  FOREIGN KEY (`RCI_ChklistId`) REFERENCES `tbl_rms_rvw_chklist_rrc` (`RRC_ChkListId`),
  FOREIGN KEY (`RCI_UpdatedBy`) REFERENCES `tbl_fou_employee_emp` (`EMP_User_id`),
  FOREIGN KEY (`RCI_RvwHdrInstanceAutoId`) REFERENCES `tbl_rms_rvw_hdr_instance_rhi` (`RHI_RvwInstanceAutoId`)
);
