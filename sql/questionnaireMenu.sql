-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查', '2125', '1', 'questionnaire', 'questionnaire/questionnaire/index', 1, 0, 'C', '0', '0', 'questionnaire:questionnaire:list', '#', 'admin', sysdate(), '', null, '供应商生命周期调查菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'questionnaire:questionnaire:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'questionnaire:questionnaire:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'questionnaire:questionnaire:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'questionnaire:questionnaire:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商生命周期调查导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'questionnaire:questionnaire:export',       '#', 'admin', sysdate(), '', null, '');