-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评', '2063', '1', 'appraisal', 'performance_appraisal/appraisal/index', 1, 0, 'C', '0', '0', 'performance_appraisal:appraisal:list', '#', 'admin', sysdate(), '', null, '供应商绩效考评菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'performance_appraisal:appraisal:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'performance_appraisal:appraisal:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'performance_appraisal:appraisal:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'performance_appraisal:appraisal:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商绩效考评导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'performance_appraisal:appraisal:export',       '#', 'admin', sysdate(), '', null, '');