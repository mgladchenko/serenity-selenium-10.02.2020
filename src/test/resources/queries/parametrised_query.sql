/**
  * Inserts a System entry into the STR" + prefix + "SYSTEM Table
  *
  * @param prefix
  *        prefix, f.e. S2B
  * @param name
  *        system name
  * @param code
  *        system code
  * @param description
  *        system description
  * @param artifactId
  *        system artifact Id
  * @param status
  *        O is for Open, C is for Closed. null == O
  * @param stat
  *        A is for Active, D is for Delete. null == A
  * @return system artifact Id
  */
 public String insertSystem(String prefix, String name, String code, String description, String artifactId,
  String status, String stat)
 {
  String systemId = getNextVal("STR" + prefix + "SYSTEM");
  status = (status != null ? status : "O");
  stat = (stat != null ? stat : "A");
  artifactId = (artifactId != null ? artifactId : getNextVal("STR" + prefix + "ARTIFACTARTIFACT"));
  String revisionId = getNextVal("STR" + prefix + "SYSTEM_REVISION");

  String sqls = "Insert into STR" + prefix
   + "SYSTEM (SYSTEM_ID, SYSTEM_REVISION, SYSTEM_ARTIFACT_ID, SYSTEM_NAME, SYSTEM_DESCRIPTION, "
   + "SYSTEM_VERSION_X, SYSTEM_VERSION_Y, SYSTEM_CODE, SYSTEM_STATUS, SYSTEM_DAT_INS, "
   + "SYSTEM_USR_INS, SYSTEM_DAT_UPD, SYSTEM_USR_UPD, SYSTEM_STAT) Values (" + systemId + ", " + // SYSTEM_ID
   revisionId + ", " + // SYSTEM_REVISION
   artifactId + ", " + // SYSTEM_ARTIFACT_ID
   "'" + name + "'," + // SYSTEM_NAME
   "'" + description + "'," + // SYSTEM_DESCRIPTION
   "1, " + // SYSTEM_VERSION_X
   "1, " + // SYSTEM_VERSION_Y
   "'" + code + "', " + // SYSTEM_CODE
   "'" + status + "', " + // SYSTEM_STATUS
   currentDateWithTimeToSQLDate + ", " + // SYSTEM_DAT_INS
   "'" + User.LCM_DEMO3.SHORT + "', " + // SYSTEM_USR_INS
   currentDateWithTimeToSQLDate + ", " + // SYSTEM_DAT_UPD
   "'" + User.LCM_DEMO3.SHORT + "', " + // SYSTEM_USR_UPD
   "'" + stat + "')"; // SYSTEM_STAT

  executeUpdate(sqls);

  return artifactId;
 }